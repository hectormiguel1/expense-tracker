import 'package:cash_flow/backend/authentication.dart';
import 'package:cash_flow/components/loginScreenButton.dart';
import 'package:cash_flow/components/textform.dart';
import 'package:cash_flow/views/ocrTest.dart';
import 'package:flutter/material.dart';

class RegisterCard extends StatefulWidget {
  _RegisterCardState createState() => _RegisterCardState();
}

class _RegisterCardState extends State<RegisterCard> {
  TextEditingController nameField = TextEditingController();
  TextEditingController emailField = TextEditingController();
  TextEditingController passwordField = TextEditingController();
  TextEditingController confirmPasswordField = TextEditingController();
  bool passwordsMatch = true;


  Widget build(BuildContext context) {
    return SizedBox(
                      height: 500,
                      width: 400,
                      child: Card(
                        color: Colors.white,
                        elevation: 20,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                        ),
                        child: Column(
                            mainAxisSize: MainAxisSize.min,
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                                TextForm(
                                  controller: nameField, 
                                  label: "Name",
                                  hintText: "Enter your name",
                                  isPasswordField: false,
                                ),
                              TextForm(
                                controller: emailField,
                                label: "Email",
                                hintText: "Enter your email",
                                isPasswordField: false,
                              ),
                              TextForm(
                                isPasswordField: true,
                                controller: passwordField,
                                label: "Create new Password",
                                hintText: "Create new Password",
                              ),

                              TextForm(
                                controller: confirmPasswordField,
                                label: "Confirm password",
                                hintText: "Confirm your password",
                                isPasswordField: true),
                              SizedBox(height: 10),
                              if(!passwordsMatch) 
                              Text("Passwords do not match!", style: TextStyle(
                                fontWeight: FontWeight.bold,
                                color: Colors.red,
                                fontSize: 24,
                              )),
                              SizedBox(height: 10,),
                              Row(
                                mainAxisSize: MainAxisSize.max,
                                mainAxisAlignment: MainAxisAlignment.center,
                                crossAxisAlignment: CrossAxisAlignment.end,
                                children: [
                                   SizedBox(
                                     width: 100,
                                     height: 50,
                                     child: LoginScreenButton(text: "Register", color: Theme.of(context).colorScheme.secondary, onTap: handleRegister, icon: Icons.add)
                                   ),                          
                                  
                                ],
                              )
                            ],
                          ),
                        ),
                    );
  }

  void handleRegister() async {
    if(passwordField.text != confirmPasswordField.text) {
      setState(() {
        passwordsMatch = false;
      });
    } 
    else {
    var result = await register(emailField.text, passwordField.text, nameField.text);
    if(result != null) {
      Navigator.of(context).pushReplacement(MaterialPageRoute(builder: (builder) => OCRTest()));
    } else {
      
    }
    }

  }

}