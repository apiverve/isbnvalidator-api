# ISBN Validator API - Dart/Flutter Client

ISBN Validator is a comprehensive tool for validating and parsing ISBN-10 and ISBN-13 book identification numbers. It validates checksums and provides detailed information about each ISBN component.

[![pub package](https://img.shields.io/pub/v/apiverve_isbnvalidator.svg)](https://pub.dev/packages/apiverve_isbnvalidator)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [ISBN Validator API](https://apiverve.com/marketplace/isbnvalidator?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_isbnvalidator: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_isbnvalidator/apiverve_isbnvalidator.dart';

void main() async {
  final client = IsbnvalidatorClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'isbn': '978-0-306-40615-7'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "valid": true,
    "isbn": "978-0-306-40615-7",
    "type": "ISBN-13",
    "normalized": "9780306406157",
    "formatted": "978-0-306-40615-7",
    "checksum_valid": true,
    "prefix": "978",
    "group": "0",
    "publisher": "306",
    "title": "40615",
    "check_digit": "7",
    "error": null
  }
}
```

## API Reference

- **API Home:** [ISBN Validator API](https://apiverve.com/marketplace/isbnvalidator?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/isbnvalidator](https://docs.apiverve.com/ref/isbnvalidator?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
