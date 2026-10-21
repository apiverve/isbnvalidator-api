# frozen_string_literal: true

Gem::Specification.new do |spec|
  spec.name          = "apiverve_isbnvalidator"
  spec.version       = "1.2.2"
  spec.authors       = ["APIVerve"]
  spec.email         = ["hello@apiverve.com"]

  spec.summary       = "ISBN Validator API - Ruby Client"
  spec.description   = "ISBN Validator checks ISBN-10 and ISBN-13 numbers for valid checksums and parses their registration group, publisher, and title parts. Pass any raw book identifier with or without hyphens to inspect normalized digits, format type, and specific rejection reasons."
  spec.homepage      = "https://apiverve.com/marketplace/isbnvalidator?utm_source=ruby&utm_medium=referral&utm_content=homepage"
  spec.license       = "MIT"
  spec.required_ruby_version = ">= 2.7.0"

  spec.metadata["homepage_uri"] = spec.homepage
  spec.metadata["source_code_uri"] = "https://github.com/apiverve/isbnvalidator-API/tree/main/ruby"
  spec.metadata["changelog_uri"] = "https://apiverve.com/changelog"
  spec.metadata["documentation_uri"] = "https://docs.apiverve.com/ref/isbnvalidator"

  spec.files = Dir.glob("{lib}/**/*") + %w[README.md LICENSE]
  spec.require_paths = ["lib"]

  spec.add_dependency "faraday", ">= 1.0", "< 3.0"
  spec.add_dependency "faraday-multipart", "~> 1.0"
  spec.add_dependency "json", "~> 2.0"
end
