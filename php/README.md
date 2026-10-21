# ISBN Validator API - PHP Package

ISBN Validator checks ISBN-10 and ISBN-13 numbers for valid checksums and parses their registration group, publisher, and title parts. Pass any raw book identifier with or without hyphens to inspect normalized digits, format type, and specific rejection reasons.

## Installation

Install via Composer:

```bash
composer require apiverve/isbnvalidator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Isbnvalidator\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['isbn' => '978-0-306-40615-7']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Isbnvalidator\Client;
use APIVerve\Isbnvalidator\Exceptions\APIException;
use APIVerve\Isbnvalidator\Exceptions\ValidationException;

try {
    $response = $client->execute(['isbn' => '978-0-306-40615-7']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/isbnvalidator?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/isbnvalidator?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/isbnvalidator?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
