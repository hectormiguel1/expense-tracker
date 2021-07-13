import 'package:cash_flow/models/Receipt.dart';

class User {
  String uid = "";
  String name = "";
  List<Receipt> receipts =  [];
  Map<String, double> limits = Map<String, double>();
  Map<String, double> currentExpenditure = Map<String, double>();


  User({
    required this.uid,
    required this.name,
    this.receipts = const [],
    this.limits = const {},
    this.currentExpenditure = const {},
  });

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      uid: json["uid"],
      name: json["name"],
      receipts: json["receipts"],
      limits: json["limits"],
      currentExpenditure: json["currentExpenditure"]
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'uid': this.uid,
      'name': this.name,
      'receipts': this.receipts,
      'limits': this.limits,
      'currentExpenditure': this.currentExpenditure
    };
  }

  
}