import 'dart:convert';
import 'dart:io';

import 'package:cash_flow/models/Receipt.dart';
import 'package:cash_flow/models/category.dart';
import 'package:cash_flow/models/item.dart';
import 'package:cash_flow/providers/credentials.dart';
import 'package:flutter/material.dart';
import 'package:googleapis/vision/v1.dart' as Google;
import 'package:file_picker/file_picker.dart';


class OCRTest extends StatefulWidget {

  _OCRTestState createState() =>  _OCRTestState();
}

class _OCRTestState extends State<OCRTest> {
  String filePath = "";
  String ocrText = "";
  var _client = CredentialsProvider().client;


  void selectFile() async {
    dynamic image;
    FilePickerResult? result = await FilePicker.platform.pickFiles(
          type: FileType.custom,
          allowedExtensions: ['jpg', 'pdf', 'doc'],
          allowMultiple: false
        );
        if(result != null) {
          image = result.files.first.bytes;
                String imageBase64 = base64Encode(image);

          parseOCR(await runOCR(imageBase64)).then( (val) => print(val.toString()));
        }
  }

  int findBegin(List<String> items) {
    int index = 0;
    items.asMap().forEach((key, value) {
      if(value.compareTo("Walmart") == 0)
        index = key;
    });
    return index;
  }

  bool isLastCharItem(String char) {
    switch(char) {
      case "P" : return true;
      case "X" : return true;
      case "N" : return true;
      case "F" : return true;
      case "O" : return true;
      case "Y" : return true;
      case "J" : return true;
      default: return false;


    }
  }

  Future<Receipt> parseOCR(String ocrResult) async {
    List<String> individualItems = ocrResult.split('\n');
    individualItems = individualItems.sublist(findBegin(individualItems), individualItems.length);
    //print(individualItems);
    List<Item>  receiptItems  = [];
    String storePhoneNumber  = "";
    String storeName  = "";
    String storeAddress  = "";
    List<double> itemValues = [];
    List<String> itemNames = [];

    for(var line in individualItems) {
      var lineItems = line.split(' ');
      if(lineItems.contains("****")) continue;
      if((isLastCharItem(lineItems.last)) && (lineItems[lineItems.length -2 ] != "Walmart")) {
        
        itemValues.add(double.parse(lineItems[lineItems.length - 2]));
        itemNames.add( lineItems.sublist(0, lineItems.length -2).join(" "));
      }

    }

    for(int i = 0; i < itemValues.length ; i++) {
      receiptItems.add(Item(category: Category.Misc, name: itemNames[i], price: itemValues[i], uid: ""));
    }

  

    return new Receipt(
      storeAddress: "",
      storeName: "",
      date: new DateTime(1,2,2),
      total: 0,
      imageURL: "",
      items: receiptItems,
      uid: "",
    );

  }

  Future<String> runOCR(String image) async {
    var _vision = Google.VisionApi(await _client);
    var _api = _vision.images;
    var _response = await _api.annotate(Google.BatchAnnotateImagesRequest.fromJson({
      "requests": [
        {
          "image": {"content": image},
          "features": [
            {"type": "DOCUMENT_TEXT_DETECTION"}
          ]
        }
      ]
    })
    );
    return _response.responses!.first.textAnnotations!.first.description!;
  }
  

  Widget build(BuildContext build) {
    return Scaffold(
      appBar: AppBar(
        title: Text('OCR Test'),
      ),
      body: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            FlatButton(child: 
            Text("Press to select Receipt Image"),
            onPressed: selectFile),
      
            if(filePath != "") 
              Image.file(File(filePath)),
            
            Text('OCR Text:' + ocrText),
          ]
        ),
      ));
  }
}