import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:cash_flow/models/marshal.dart';

const String backEndBaseUrl = "http://localhost:8080/";



Future<void> add<T>({required String endPoint, required T object}) async {
  print(
      'Adding ${Marshal.getType<T>()}: ${json.encode(Marshal.toJson<T>(object))}');
  var composedEndPoint = backEndBaseUrl + Marshal.getTypeEndPoint<T>() + '/$endPoint';

  var response = await http.post(Uri.parse(composedEndPoint),
      body: json.encode(Marshal.toJson<T>(object)),
      headers: {'Content-Type': 'application/json'});
  if (response.statusCode == 200) {
    print('${Marshal.getType<T>()} Added');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}

Future<List<T>> get<T>({required String endPoint}) async {
  print(
      'Getting ${Marshal.getType<T>()} from DB');
  var composedEndPoint = backEndBaseUrl + '/$endPoint';
  var response = await http.get(Uri.parse(composedEndPoint),
      headers: {'Content-Type': 'application/json'});
  if (response.statusCode == 200) {
    print('${Marshal.getType<T>()} from DB');
    var jsonResponse = json.decode(response.body);
    var list = json.decode(jsonResponse);
    List<T> items = [];
    for (var item in list) {
      items.add(Marshal.fromJson<T>(item));
    }
    return items;
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
  return [];
}


}