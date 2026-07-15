declare module '@apiverve/isbnvalidator' {
  export interface isbnvalidatorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface isbnvalidatorResponse {
    status: string;
    error: string | null;
    data: ISBNValidatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface ISBNValidatorData {
      valid:         boolean | null;
      isbn:          null | string;
      type:          null | string;
      normalized:    null | string;
      formatted:     null | string;
      checksumValid: boolean | null;
      prefix:        null | string;
      group:         null | string;
      publisher:     null | string;
      title:         null | string;
      checkDigit:    null | string;
      error:         null;
  }

  export default class isbnvalidatorWrapper {
    constructor(options: isbnvalidatorOptions);

    execute(callback: (error: any, data: isbnvalidatorResponse | null) => void): Promise<isbnvalidatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: isbnvalidatorResponse | null) => void): Promise<isbnvalidatorResponse>;
    execute(query?: Record<string, any>): Promise<isbnvalidatorResponse>;
  }
}
