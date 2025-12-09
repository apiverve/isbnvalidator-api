from setuptools import setup, find_packages

setup(
    name='apiverve_isbnvalidator',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='ISBN Validator is a comprehensive tool for validating and parsing ISBN-10 and ISBN-13 book identification numbers. It validates checksums and provides detailed information about each ISBN component.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
