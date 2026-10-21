# ISBN Validator API - Ruby Gem

ISBN Validator checks ISBN-10 and ISBN-13 numbers for valid checksums and parses their registration group, publisher, and title parts. Pass any raw book identifier with or without hyphens to inspect normalized digits, format type, and specific rejection reasons.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_isbnvalidator'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_isbnvalidator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_isbnvalidator'

# Initialize the client
client = APIVerve::Isbnvalidator::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ isbn: "978-0-306-40615-7" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ isbn: "978-0-306-40615-7" })
  puts response["data"]
rescue APIVerve::Isbnvalidator::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Isbnvalidator::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Isbnvalidator::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/isbnvalidator?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/isbnvalidator?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/isbnvalidator?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
