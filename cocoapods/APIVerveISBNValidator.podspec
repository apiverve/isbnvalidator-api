Pod::Spec.new do |s|
  s.name             = 'APIVerveISBNValidator'
  s.version          = '1.2.3'
  s.summary          = 'ISBN Validator checks ISBN-10 and ISBN-13 numbers for valid checksums and parses their registration group, publisher, and title parts.'
  s.description      = <<-'DESC'
ISBN Validator checks ISBN-10 and ISBN-13 numbers for valid checksums and parses their registration group, publisher, and title parts. Pass any raw book identifier with or without hyphens to inspect normalized digits, format type, and specific rejection reasons.

This iOS/macOS SDK provides a convenient way to access the ISBN Validator from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/isbnvalidator?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/isbnvalidator-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveISBNValidator/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
