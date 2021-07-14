import 'package:flutter/material.dart';

class TextForm extends StatefulWidget {
  final bool isPasswordField;
  final TextEditingController controller;

  TextForm({required this.isPasswordField, required this.controller});

  _TextFormState createState() => _TextFormState(isPasswordField: this.isPasswordField, controller: this.controller);

}

class _TextFormState extends State<TextForm> {
  TextEditingController controller;
  bool isPasswordField;

  _TextFormState({required this.isPasswordField, required this.controller});
  

  Widget build(BuildContext context) {
    return Container();
  }
  
}