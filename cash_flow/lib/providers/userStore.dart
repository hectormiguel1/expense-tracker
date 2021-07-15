import 'package:cash_flow/models/user.dart';
import 'package:get/get.dart';

class UserStore extends GetxController {
  User? loggedInUser;
  late final Rx<User?> userObserver;

  UserStore() {
     this.userObserver = loggedInUser.obs;
  }

  bool isUserLoggedIn() {
    return loggedInUser == null;
  }

  void loginUser(User user) {
    loggedInUser = user;
    update();
  } 
  

}