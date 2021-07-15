import 'package:cash_flow/components/loginScreenButton.dart';
import 'package:cash_flow/components/textform.dart';
import 'package:flutter/material.dart';

class LoginCard extends StatefulWidget {
  LoginCard({this.registerOnTap, this.loginOnTap});
  final registerOnTap;
  final loginOnTap;
  _LoginCardState createState() => new _LoginCardState(registerOnTap: this.registerOnTap, loginOnTap: this.loginOnTap);
}

class _LoginCardState extends State<LoginCard> {
  TextEditingController emailField = new TextEditingController();
  TextEditingController passwordField = new TextEditingController();
  final registerOnTap;
  final loginOnTap;

  _LoginCardState({this.registerOnTap, this.loginOnTap});

  Widget build(BuildContext context) {
    return SizedBox(
                      height: 300,
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
                              TextForm(isPasswordField: false, controller: emailField, hintText: "Enter your email", label: "Email"),
                              TextForm(isPasswordField: true,controller: passwordField, label: "Password", hintText: "Enter your password"),
                              SizedBox(height: 20,),
                              Row(
                                mainAxisSize: MainAxisSize.max,
                                mainAxisAlignment: MainAxisAlignment.center,
                                crossAxisAlignment: CrossAxisAlignment.end,
                                children: [
                                   SizedBox(
                                     width: 100,
                                     height: 50,
                                     child: LoginScreenButton(text: "Register", color: Theme.of(context).colorScheme.secondary, onTap: handleRegisterTapped , icon: Icons.add)
                                   ),
                                  SizedBox(width: 50,),                   
                                  SizedBox(
                                    width: 100,
                                    height: 50,
                                    child: LoginScreenButton(text: "Login", icon: Icons.check, color: Theme.of(context).colorScheme.primary, onTap: handleLoginTapped))                           
                                ],
                              )
                            ],
                          ),
                        ),
                    );
  }

  void handleRegisterTapped() {
    this.registerOnTap();
  }

  void handleLoginTapped() {
    this.loginOnTap(email: emailField.text, password: passwordField.text);
  }


}