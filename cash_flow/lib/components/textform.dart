import 'package:flutter/material.dart';

class TextForm extends StatefulWidget {
  final bool isPasswordField;
  final TextEditingController controller;
  final String label;
  final String hintText;

  const TextForm({required this.isPasswordField, required this.controller, required this.hintText, required this.label});

  _TextFormState createState() => _TextFormState(isPasswordField: this.isPasswordField, controller: this.controller, label: this.label, hintText: this.hintText);

}

class _TextFormState extends State<TextForm> {
  TextEditingController controller;
  bool isPasswordField;
  final String label;
  final String hintText;

  _TextFormState({required this.isPasswordField, required this.controller, required this.label, required this.hintText});
  

  Widget build(BuildContext context) {
    return Padding(
                                padding: EdgeInsets.fromLTRB(12, 12, 12, 12),
                                child: Row(
                                  mainAxisSize: MainAxisSize.min,
                                  crossAxisAlignment: CrossAxisAlignment.center,
                                  children: [            
                                      Container(
                                        width: 330,
                                        height: 60,
                                        decoration: BoxDecoration(
                                          color: Colors.white,
                                          borderRadius: BorderRadius.circular(8),
                                          border: Border.all(
                                            color: Color(0xFFE6E6E6),
                                          
                                        )),
                                        child: Padding(
                                          padding:
                                              EdgeInsets.fromLTRB(20, 20, 20, 20),
                                          child: TextFormField(
                                            controller: controller,
                                            obscureText: isPasswordField,
                                            decoration: InputDecoration(
                                              labelText: label,
                                            
                                              hintText: hintText,
                                               enabledBorder: UnderlineInputBorder(
                                                borderSide: BorderSide(
                                                  color: Color(0x00000000),
                                                  width: 1,
                                                ),
                                                borderRadius: const BorderRadius.only(
                                                  topLeft: Radius.circular(4.0),
                                                  topRight: Radius.circular(4.0),
                                                ),
                                              ),
                                              focusedBorder: UnderlineInputBorder(
                                                borderSide: BorderSide(
                                                  color: Color(0x00000000),
                                                  width: 1,
                                                ),
                                                borderRadius: const BorderRadius.only(
                                                  topLeft: Radius.circular(4.0),
                                                  topRight: Radius.circular(4.0),
                                                ),
                                              ),
                                            
                                            )   
                                          ),
                                        ),
                                      ),
                                    
                                  ],
                                ),
                              );
  }
  
}