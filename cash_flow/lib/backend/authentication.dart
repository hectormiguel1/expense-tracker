import 'package:cash_flow/models/Receipt.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:cash_flow/models/user.dart' as Model;
import 'package:cash_flow/backend/backendconnection.dart' as Database;


FirebaseAuth _auth = FirebaseAuth.instance;

Future<Model.User?> register(String email, String password, String name) async {
  Model.User? modelUser;
  try{
  _auth.createUserWithEmailAndPassword(email: email, password: password).then((val) {
    var modeluser = Model.User(name: name, uid: val.user!.uid, receipts: [], limits: Map<String, double>(), currentExpenditure: Map<String, double>());
        modelUser = modeluser;

    Database.add<Model.User>(endPoint: "newUser", object: modelUser!).then((_) {
      print("Connected with DB");
    });
    return modeluser;
  } );
  } on Error catch(e) {
    print("Null somewhere");
  }
  
}

Future<Model.User?> login(String email, String password) async {
  Model.User? loadedUser;
  await _auth.signInWithEmailAndPassword(email: email, password: password).then( (user) async {
    var modelUser = Model.User(name: user.user!.displayName!, uid: user.user!.uid);
    await Database.get<Receipt>(endPoint: '/user/${modelUser.uid}/receipts').then((receipts) => modelUser.receipts = receipts);
    await Database.get<Map<String, double>>(endPoint: '/user/${modelUser.uid}/limits').then((limits) => modelUser.limits = limits.single);
    await Database.get<Map<String, double>>(endPoint: '/user/${modelUser.uid}/expenditure').then((expenditure) => modelUser.currentExpenditure = expenditure.single);
    loadedUser = modelUser;
  }).onError((error, stackTrace) {
    print('Error: ${error}');
    throw Exception("Unable to login, or fetch data");
  });
  return loadedUser;
} 