import 'package:cash_flow/components/loginScreenButton.dart';
import 'package:flutter/material.dart';

class RegisterCard extends StatefulWidget {
  _RegisterCardState createState() => _RegisterCardState();
}

class _RegisterCardState extends State<RegisterCard> {
  TextEditingController nameField = new TextEditingController();
  TextEditingController emailField = new TextEditingController();
  TextEditingController passwordField = new TextEditingController();
  TextEditingController confirmPasswordField = new TextEditingController();


  Widget build(BuildContext context) {
    return SizedBox(
                      height: 500,
                      width: 400,
                      child: Card(
                        color: Color(0xFFF5F5F5),
                        elevation: 20,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                        ),
                        child: Column(
                            mainAxisSize: MainAxisSize.min,
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Padding(
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
                                            controller: emailField,
                                            obscureText: false,
                                            decoration: InputDecoration(
                                              labelText: 'Email',
                                            
                                              hintText: 'Please enter your email....',
                                             
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
                              ),
                              Padding(
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
                                            controller: passwordField,
                                            obscureText: true,
                                            decoration: InputDecoration(
                                              labelText: 'Password',
                                            
                                              hintText: 'Please enter your password....',
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
                              ),
                              SizedBox(height: 20,),
                              Row(
                                mainAxisSize: MainAxisSize.max,
                                mainAxisAlignment: MainAxisAlignment.center,
                                crossAxisAlignment: CrossAxisAlignment.end,
                                children: [
                                   SizedBox(
                                     width: 100,
                                     height: 50,
                                     child: LoginScreenButton(text: "Register", color: Theme.of(context).colorScheme.secondary, onTap: () {}, icon: Icons.add)
                                   ),
                                  
                                  SizedBox(width: 50,),                   
                                  SizedBox(
                                    width: 100,
                                    height: 50,
                                    child: LoginScreenButton(text: "Login", icon: Icons.check, color: Theme.of(context).colorScheme.primary, onTap: () {}))
                                  
                              
                                  
                                ],
                              )
                            ],
                          ),
                        ),
                    );
  }

}