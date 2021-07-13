import 'package:cash_flow/models/item.dart';

class Receipt {
  String imageURL;
  List<Item> items = [];
  double total;
  String storeName;
  String storeAddress;
  DateTime date;
  String uid;

Receipt({
  required this.imageURL,
  required this.items,
  required this.total,
  required this.storeName,
  required this.storeAddress,
  required this.date,
  required this.uid
});

factory Receipt.fromJson(Map<String, dynamic> json) {
  return Receipt(
    imageURL: json["imageURL"],
    items: json["items"],
    total: json["total"],
    storeName: json["storeName"],
    storeAddress: json["storeAddress"],
    date: new DateTime(json["date"]),
    uid: json["uid"],
  );
}

  Map<String, dynamic> toJson() {
    return {
      "imageURL": this.imageURL,
      "items": this.items,
      "total": this.total,
      "storeName": this.storeName,
      "storeAddress": this.storeAddress,
      "date": this.date.toString(),
      "uid": this.uid,
    };
  }
  

}