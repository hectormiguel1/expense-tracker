enum Category {
   Food,
    Gas,
    Clothing,
    Entertainment,
    Misc,
    Technology,
    Pharmacy,
    Sports,
    Personal_Care,
    Household,
    Jewelery,
    Garden,
    Pet,
    Car,
    Baby
}

String enumToString<T>(T value) {
  return value.toString().split(".")[1];
}

T enumFromString<T>(Iterable<T> values, String value) {
  return values.firstWhere((type) => type.toString().split(".").last == value,
      orElse: () => throw Exception('Not such ENUM $value'));
}