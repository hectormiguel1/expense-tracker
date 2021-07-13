import 'package:flutter/material.dart';

class LoginScreenButton extends StatelessWidget {
  final String text;
  final Color color;
  final IconData icon;
  final onTap;

  LoginScreenButton({required this.text, required this.icon, required this.color, required this.onTap});

  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: onTap,
      child: Row(children: [
        Icon(icon),
        SizedBox(width: 5,),
        Text(text),
      ]),
      style: ButtonStyle(
        elevation: MaterialStateProperty.all<double>(20),
        backgroundColor: MaterialStateProperty.all<Color>(color),
        shape: MaterialStateProperty.all<OutlinedBorder>(RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)))
      ),
    );
  }

}