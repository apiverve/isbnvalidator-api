using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.ISBNValidator
{
    /// <summary>
    /// Query options for the ISBN Validator API
    /// </summary>
    public class ISBNValidatorQueryOptions
    {
        /// <summary>
        /// The ISBN number to validate (ISBN-10 or ISBN-13, with or without separators)
        /// Example: 978-0-306-40615-7
        /// </summary>
        [JsonProperty("isbn")]
        public string Isbn { get; set; }
    }
}
