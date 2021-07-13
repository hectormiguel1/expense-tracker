import 'package:cash_flow/models/category.dart';

class Item {
  Category category;
  String name;
  double price;
  String uid;

  Item({
    required this.category,
    required this.name,
    required this.price,
    required this.uid
  });

  factory Item.fromJson(Map<String, dynamic> json) {
    return new Item(
      category: enumFromString<Category>(Category.values, json["category"]) ,
      name: json["name"],
      price: json["price"],
      uid: json["uid"]
    );
  }

  Map<String, dynamic> toJson() {
    return {
      "category": enumToString(category),
      "name": name,
      "price": price,
      "uid": uid
    };
  }
}