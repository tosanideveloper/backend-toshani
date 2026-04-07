/**
 * 
 */
package com.toshaniFintech.common.utils;

import java.util.UUID;

public final class AppConstant {

	private AppConstant() {
		// empty constructor
	}

	public static final String STATUS_0 = "0";
	public static final String STATUS_1 = "1";
	public static final String STATUS_2 = "2";

	public static final String EMPLOYEE_ID_PARAM_NAME = "employeeId";
	public static final String BRANCH_ID_PARAM_NAME = "branchId";
	public static final String FIELD_EXECUTIVE_ID_PARAM_NAME = "fieldExecutiveId";
	public static final String CASE_ID_PARAM_NAME = "caseId";
	public static final String LOAN_NUMBER_PARAM_NAME = "loanNumber";
	public static final String CHEQUE_NO = "chequeNo";
	public static final String USER_ID = "user_id";
	public static final String BANK_ID = "bankId";
	public static final String BULK_UPLOAD_HISTORY_ID = "uploadId";
	public static final String SETTLEMENT_STATUS_INITIATE  = "initiated";
	public static final String SETTLEMENT_STATUS_BANK_APPROVED = "bank_approved";


	public static final String BRANCH_NAME = "branchName";
	public static final String BANK_NAME = "bankName";


	public static final String AGENCY_ID_PARAM = "agencyId";
	public static final String LOAN_NUMBER_PARAM = "loanNumber";
	public static final String BRANCH_CODE_PARAM_NAME = "code";
	public static final String BRANCH_NAME_PARAM = "name";
	public static final String BRANCH_CITY_PARAM = "city";
	public static final String TRAIL_CLAIM_STATUS_REQ_PARAM = "trailClaimStatus";
	public static final String TRAIL_STATUS_REQ_PARAM = "trailStatus";
	public static final String PAYMENT_MODE = "paymentMode";
	public static final String STATE_REQ_PARAM = "state";
	public static final String STATE_REQ_NAME = "name";
	public static final String COUNTRY_REQ_COUNTRY = "country";
	public static final String PROJECTION_REQ_PARAM = "projections";
	public static final String PROJECTION_VALUE_AGENCY = "agency";
	public static final String PROJECTION_VALUE_EMPLOYEE = "employee";
	public static final String COUNTRY_REQ_NAME = "name";
	public static final String GLOBAL_STATUS_REQ_PARAM= "status";
	
	// pagination
	public static final String PAGE_NUMBER_PROPERTY_NAME = "page_number";
	public static final String PAGE_NUMBER_DEFAULT_VALUE = "0";
	public static final String PAGE_SIZE_PROPERTY_NAME = "page_size";
	public static final String PAGE_SIZE_DEFAULT_VALUE = "10";
	public static final String PAGE_SIZE_DEFAULT_VALUE_1000 = "1000";
	public static final String SORT_BY_PROPERTY_NAME = "sort_by";
	public static final String SORT_BY_DEFAULT_VALUE = "createdAt";
	public static final String SORT_BY_DEFAULT_VALUE_NATIVE = "created_at";
	public static final String ORDER_TYPE_PROPERTY_NAME = "order_type";
	public static final String ORDER_TYPE_DEFAULT_VALUE = "desc";
	public static final String SEARCH_PROPERTY_NAME = "search";

	public static final String LOG_ENTRY_METHOD = "Entry in Method: TID->";
	public static final String LOG_EXIT_METHOD = "Exit from method: TID->";
	public static final String LOG_EXCEPTION_METHOD = "Exception in method: TID->";
	public static final String TRANSACTION_ID = "transactionId";
	public static final String DEFAULT_ERROR_MSG = "Failed to process request";
	public static final String PHONE_ALREADY_EXISTS = "Phone number already exists";
	public static final String EMAIL_ALREADY_EXISTS = "Email already exists";
	public static final String AGENCY_NAME_ALREADY_EXISTS = "Agency name already exists";
	public static final String AGENCY_LAND_LINE_ALREADY_EXISTS = "Agency landline no already exists";
	public static final String AGENCY_ALTERNATE_NUMBER_ALREADY_EXISTS = "Agency alternate phone number already exists";

	

	public static final String EMPTY_STRING = "";

	public static final String HEADER_STATUS_NAME = "status";
	public static final String HEADER_STATUS_SUCCESS = "1";
	public static final String HEADER_STATUS_FAILURE = "0";
	public static final String HEADER_STATUS_MSG = "msg";

	public static final String REQ_PARAM_ISDELETED_NAME = "is_deleted";
	public static final String REQ_PARAM_KYC_TYPE_NAME = "kyc_type";
	public static final String KYC_TYPE_NAME_AGENCY = "agency";
	public static final String KYC_TYPE_NAME_BRANCH = "branch";
	public static final String KYC_TYPE_NAME_EMPLOYEE = "employee";
	public static final String SOURCE_NAME = "source";
	public static final String SOURCE_NAME_VALUE_AGENCY = "agency";
	public static final String SOURCE_NAME_VALUE_BRANCH = "branch";
	public static final String SOURCE_NAME_VALUE_EMPLOYEE = "employee";


	public static final String JPA_UNIQUE_KEY_PREFIX = "UK_";

	public static final String AGENT_CLIENT = "BP-AGENCY";
	public static final String NOTIFICATION_CLIENT = "BP-NOTIFICATION";
	public static final String AUTH_CLIENT = "BP-AUTH";
	public static final String SETTINGS_CLIENT = "BP-SETTINGS";
	public static final String CASE_CLIENT = "BP-CASE";

	public static final String MSG_RECORD_NOT_FOUND = "Record Not Found";
	public static final String MSG_INVALID_CREDENTIALS = "Invalid Credentials";
	public static final String MSG_VALIDATION_ERROR = "Validation Error";
	public static final String MSG_INTERNAL_ERROR = "Internal Error";
	public static final String MSG_UNAUTHORIZE_ACCESS = "UnAuth Access";
	public static final String MSG_SQL_EXCEPTION = "Database Exception";

	public static final String AUTH_HEADER_USER_ID = "user_id";
	public static final String AUTH_HEADER_USER_ROLE = "user_role";
	public static final String AUTH_HEADER_USER_AGENCY_ID = "agency_id";
	public static final String AUTH_HEADER_USER_BRANCH_ID = "branch_id";
	public static final String AUTH_HEADER_AUTHRIZATION = "Authorization";
	public static final String AUTH_HEADER_TOKEN_PREFIX = "Bearer ";

	public static final String AUTHORITIES_KEY = "Authorities";
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	public static final long OTP_VALIDITY = 5;
	public static final String COUNTRY_CODE = "+91";
	public static final String USER_ROLE_CODE_FOR_ADMIN = "1";

	public static final String USER_ROLE_SEQUENCE_KEY = "user_role_seq";
	public static final String BPAGENCYBUCKET = "bp-agency-bucket-";
	public static final String KYC_TYPE_ID_PARAM = "kycTypeId";
	
	public static final String DATE_FORMAT_DDMMYYYY = "dd-MM-yyyy";
	public static final String DATE_FORMAT_DDMMMYYYY = "dd-MMM-yyyy";
	public static final String DATE_FORMAT_UNIQUE = "yyMMddHHmmss";
	public static final String DATE_FORMAT_STANDARD = "yyyy-MM-dd'T'HH:mm:ssZ";
	public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
	public static final String TIME_FORMAT_HMMSS ="H:mm:ss";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String NULL_PARAM = "null";
	
	public static final String OTP_ID="otpId";
	public static final String THREAD_POOL_NAME="BP-THREAD";
	
	public static final String SOURCE_AGENCY = "agency";
	public static final String SOURCE_BRANCH = "branch";
	public static final String SOURCE_EMPLOYEE = "employee";

	public static final String FILE_EXTENSION_FOR_ALL = "jpg,jpeg,png,pdf,xlsx,doc,txt";
	public static final String FILE_EXTENSION_FOR_IMAGE = "jpg,jpeg,png";
	public static final String FILE_EXTENSION_FOR_EXCEL = "xlsx,xls";

	public static final String FILE_REQ_PARAM = "file";
	
	public static final String ONLY_DIGIT_REGEX="[0-9]+";

	public static final String IS_AGENCY_SIGNUP = "isAgencySignUp";
	public static final String PREFIX_AGENCY_CODE = "A";
	public static final String PREFIX_BRANCH_CODE = "B";
	public static final String PREFIX_EMPLOYEE_CODE = "E";
	public static final String DEPARTMENT_ID_PARAM_NAME = "departmentId";
	public static final String DESIGNATION_ID_PARAM_NAME = "designationId";
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";
	
	public static final String SHEET_TEMPLATE_NAME = "Template";

	public static final String CASE_CONTACT_DETAILS_PHONE_TYPE = "PHONE";
	public static final String CASE_CONTACT_DETAILS_ADDRESS_TYPE = "ADDRESS";

	
	public static final String generateRandomString() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
