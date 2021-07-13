
import 'package:cash_flow/models/Receipt.dart';
import 'package:cash_flow/models/item.dart';
import 'package:cash_flow/models/user.dart';

class Marshal {

static Type getType<T>() => T;

static dynamic fromJson<T>(Map<String, dynamic> json) {
  switch(getType<T>()) {
    case User: return User.fromJson(json);
    case Receipt: return Receipt.fromJson(json);
    case Item: return Item.fromJson(json);
    default: throw new Exception("Unsupported type");
  }
}

static Map<String, dynamic> toJson<T>(T obj) {
  switch(getType<T>()) {
    case User: return (obj as User).toJson();
    case Receipt: return (obj as Receipt).toJson();
    case Item: return (obj as Item).toJson();
    default: throw new Exception("Unsupported type"); 
  }
}

  static String getTypeEndPoint<T>() {
    switch(getType<T>()) {
      case User: return 'users';
      case Receipt: return 'receipts';
      case Item: return 'items';
      default: throw new Exception("Unsupported type");
    }
    }


}