/// Response models for the ISBN Validator API.

/// API Response wrapper.
class IsbnvalidatorResponse {
  final String status;
  final dynamic error;
  final IsbnvalidatorData? data;

  IsbnvalidatorResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory IsbnvalidatorResponse.fromJson(Map<String, dynamic> json) => IsbnvalidatorResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? IsbnvalidatorData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the ISBN Validator API.

class IsbnvalidatorData {
  bool? valid;
  String? isbn;
  String? type;
  String? normalized;
  String? formatted;
  bool? checksumValid;
  String? prefix;
  String? group;
  String? publisher;
  String? title;
  String? checkDigit;
  dynamic error;

  IsbnvalidatorData({
    this.valid,
    this.isbn,
    this.type,
    this.normalized,
    this.formatted,
    this.checksumValid,
    this.prefix,
    this.group,
    this.publisher,
    this.title,
    this.checkDigit,
    this.error,
  });

  factory IsbnvalidatorData.fromJson(Map<String, dynamic> json) => IsbnvalidatorData(
      valid: json['valid'],
      isbn: json['isbn'],
      type: json['type'],
      normalized: json['normalized'],
      formatted: json['formatted'],
      checksumValid: json['checksum_valid'],
      prefix: json['prefix'],
      group: json['group'],
      publisher: json['publisher'],
      title: json['title'],
      checkDigit: json['check_digit'],
      error: json['error'],
    );
}

class IsbnvalidatorRequest {
  String isbn;

  IsbnvalidatorRequest({
    required this.isbn,
  });

  Map<String, dynamic> toJson() => {
      'isbn': isbn,
    };
}
