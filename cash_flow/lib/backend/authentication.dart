import 'package:firebase_auth/firebase_auth.dart';
import 'package:cash_flow/models/user.dart' as Model;
import 'package:cash_flow/backend/backendconnection.dart' as Database;


FirebaseAuth _auth = FirebaseAuth.instance;

Future<Model.User> register(String email, String password, String name) async {
  UserCredential user = await _auth.createUserWithEmailAndPassword(email: email, password: password);

  if(user != null) {
    var modelUser = Model.User(name: name, uid: user.user!.uid);
    Database.add<Model.User>(endPoint: "", object: modelUser);
    return modelUser;
  } else throw Exception("Error creating account");
  
  
}

Future<Model.User> login(String email, String password) async {
  UserCredential user = await _auth.signInWithEmailAndPassword(email: email, password: password);
  if(user != null) {
    var modelUser = Database.getUser(user.user!.uid);
    return modelUser;
  } else throw Exception("Error logging in");
} 