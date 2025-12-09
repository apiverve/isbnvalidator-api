declare module '@apiverve/isbnvalidator' {
  export interface isbnvalidatorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface isbnvalidatorResponse {
    status: string;
    error: string | null;
    data: ISBNValidatorData;
    code?: number;
  }


  interface ISBNValidatorData {
      valid:         boolean;
      isbn:          string;
      type:          string;
      normalized:    string;
      formatted:     string;
      checksumValid: boolean;
      prefix:        string;
      group:         string;
      publisher:     string;
      title:         string;
      checkDigit:    string;
      error:         null;
  }

  export default class isbnvalidatorWrapper {
    constructor(options: isbnvalidatorOptions);

    execute(callback: (error: any, data: isbnvalidatorResponse | null) => void): Promise<isbnvalidatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: isbnvalidatorResponse | null) => void): Promise<isbnvalidatorResponse>;
    execute(query?: Record<string, any>): Promise<isbnvalidatorResponse>;
  }
}
