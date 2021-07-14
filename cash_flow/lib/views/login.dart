import 'package:cash_flow/components/logincard.dart';
import 'package:cash_flow/components/registerCard.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import '../backend/authentication.dart' as Auth;

class Login extends StatefulWidget {

  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final scaffoldKey = GlobalKey<ScaffoldState>();
  Widget? bodyWidget;

  

  static void login({required String email, required String password}) {
    var user =  Auth.login(email, password); 
    if(user != null) {
      //Move to another home screen. 
    }
  }

  void register() {
    //Chanage Widget to register Widget. 
    setState(() => bodyWidget = RegisterCard());
  }

  initBodyWidget() {
    bodyWidget = new LoginCard(loginOnTap: login,registerOnTap: register);
  }

  
  
  @override
  Widget build(BuildContext context) {
    if(bodyWidget == null) {
      initBodyWidget();
    }
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
                          // clipBehavior: Clip.antiAlias,
                          //  decoration: BoxDecoration(
                          //    borderRadius: BorderRadius.circular(100),
                          //    backgroundBlendMode: BlendMode.color,
                          //    color: Colors.white)
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
                    bodyWidget!
                  ],
                ),
              ),
            ),
      ),
       
    
    );
  }
}
