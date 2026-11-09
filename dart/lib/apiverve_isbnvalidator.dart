/// ISBN Validator API client for Dart/Flutter
///
/// ISBN Validator checks ISBN-10 and ISBN-13 numbers for valid checksums, parses their registration group, publisher, and title parts, and converts a valid number to its ISBN-10 and ISBN-13 forms. Pass any raw book identifier with or without hyphens to inspect normalized digits, format type, and specific rejection reasons.
///
/// For more information, visit: https://apiverve.com/marketplace/isbnvalidator?utm_source=dart&utm_medium=referral&utm_content=readme
library apiverve_isbnvalidator;

export 'src/client.dart';
export 'src/models.dart';
