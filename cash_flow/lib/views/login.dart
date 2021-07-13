import 'package:cash_flow/components/loginScreenButton.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class Login extends StatefulWidget {

  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  late TextEditingController textController1;
  late TextEditingController textController2;
  late bool passwordVisibility;
  final scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  void initState() {
    super.initState();
    textController1 = TextEditingController();
    textController2 = TextEditingController();
    passwordVisibility = false;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: scaffoldKey,

      body: SizedBox.expand(
        child: Container(
            decoration: BoxDecoration(
              gradient: LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
                colors: [

                  Colors.green[300]!,

                  Colors.green[600]!,

                  Colors.green[900]!,
                ]
              )
            ),
            child: SingleChildScrollView(
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    
                        Container(
                          
                          child: Icon(FontAwesomeIcons.solidMoneyBillAlt,
                          color: Colors.green[900],
                          size: 100),
                          clipBehavior: Clip.antiAlias,
                           decoration: BoxDecoration(
                             borderRadius: BorderRadius.circular(100),
                             backgroundBlendMode: BlendMode.color,
                             color: Colors.white)
                          ),
                        

                    SizedBox(height: 20), 
                    Text(
                      'CashFlow',
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        color: Colors.white,
                        fontSize: 36,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    SizedBox(
                      height: 40,
                    ),
                    SizedBox(
                      height: 300,
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
                                            controller: textController1,
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
                                            controller: textController2,
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
                    ),
                    
                  ],
                ),
              ),
            ),
      ),
       
    
    );
  }
}
