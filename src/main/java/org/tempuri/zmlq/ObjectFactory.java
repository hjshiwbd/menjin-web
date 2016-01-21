
package org.tempuri.zmlq;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri.zmlq package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InitInStrDBAddr_QNAME = new QName("", "in-strDBAddr");
    private final static QName _InitInStrDBName_QNAME = new QName("", "in-strDBName");
    private final static QName _InitInStrDBUser_QNAME = new QName("", "in-strDBUser");
    private final static QName _InitInStrDBPassword_QNAME = new QName("", "in-strDBPassword");
    private final static QName _InitInStrPCAddr_QNAME = new QName("", "in-strPCAddr");
    private final static QName _InitInStrPCUser_QNAME = new QName("", "in-strPCUser");
    private final static QName _InitResponseInStrPCPassword_QNAME = new QName("", "in-strPCPassword");
    private final static QName _GetAllPersonsResponseOutStructPersons_QNAME = new QName("", "out-structPersons");
    private final static QName _GetAllBadgeTypesInSPersonID_QNAME = new QName("", "in-sPersonID");
    private final static QName _GetAllBadgeTypesResponseOutStructBadgeTypes_QNAME = new QName("", "out-structBadgeTypes");
    private final static QName _GetAllCardsResponseOutStructCards_QNAME = new QName("", "out-structCards");
    private final static QName _GetAllCompanysInStrCARDNO_QNAME = new QName("", "in-strCARDNO");
    private final static QName _GetAllCompanysResponseOutStructCompanys_QNAME = new QName("", "out-structCompanys");
    private final static QName _GetAllACCodesInStrPersonID_QNAME = new QName("", "in-strPersonID");
    private final static QName _GetAllACCodesInStrCardNO_QNAME = new QName("", "in-strCardNO");
    private final static QName _GetAllACCodesResponseOutStructACCodes_QNAME = new QName("", "out-structACCodes");
    private final static QName _GetCompanyACCodesInStrCompanyID_QNAME = new QName("", "in-strCompanyID");
    private final static QName _GetACCodeAccessDurationInStrACCodeID_QNAME = new QName("", "in-strACCodeID");
    private final static QName _GetACCodeAccessDurationResponseOutStructAccessDuration_QNAME = new QName("", "out-structAccessDuration");
    private final static QName _GetAllReadersResponseOutStructReaders_QNAME = new QName("", "out-structReaders");
    private final static QName _GetAllTimeZonesInStrReaderID_QNAME = new QName("", "in-strReaderID");
    private final static QName _GetAllTimeZonesResponseOutStructTimeZone_QNAME = new QName("", "out-structTimeZone");
    private final static QName _QueryPersonsInStrField_QNAME = new QName("", "in-strField");
    private final static QName _QueryPersonsInStrOper_QNAME = new QName("", "in-strOper");
    private final static QName _QueryPersonsInStrValue_QNAME = new QName("", "in-strValue");
    private final static QName _AddPersonInStructPerson_QNAME = new QName("", "in-structPerson");
    private final static QName _AddPersonInStrBadgeTypeID_QNAME = new QName("", "in-strBadgeTypeID");
    private final static QName _AddPersonResponseSPersonID_QNAME = new QName("", "sPersonID");
    private final static QName _AddCardInStructCard_QNAME = new QName("", "in-structCard");
    private final static QName _AddReaderToACCodeResponseInStrTimeZoneID_QNAME = new QName("", "in-strTimeZoneID");
    private final static QName _AddReaderToCardInStrTEMPACCESS_QNAME = new QName("", "in-strTEMPACCESS");
    private final static QName _AddReaderToCardInStrTEMPACCESSSTARTTIME_QNAME = new QName("", "in-strTEMPACCESS-START-TIME");
    private final static QName _AddReaderToCardResponseInStrTEMPACCESSENDTIME_QNAME = new QName("", "in-strTEMPACCESS-END-TIME");
    private final static QName _GetReaderStatusResponseInStrStatus_QNAME = new QName("", "in-strStatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri.zmlq
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link Uninit }
     * 
     */
    public Uninit createUninit() {
        return new Uninit();
    }

    /**
     * Create an instance of {@link GetAllPersons }
     * 
     */
    public GetAllPersons createGetAllPersons() {
        return new GetAllPersons();
    }

    /**
     * Create an instance of {@link GetAllPersonsResponse }
     * 
     */
    public GetAllPersonsResponse createGetAllPersonsResponse() {
        return new GetAllPersonsResponse();
    }

    /**
     * Create an instance of {@link GetAllBadgeTypes }
     * 
     */
    public GetAllBadgeTypes createGetAllBadgeTypes() {
        return new GetAllBadgeTypes();
    }

    /**
     * Create an instance of {@link GetAllBadgeTypesResponse }
     * 
     */
    public GetAllBadgeTypesResponse createGetAllBadgeTypesResponse() {
        return new GetAllBadgeTypesResponse();
    }

    /**
     * Create an instance of {@link GetAllCards }
     * 
     */
    public GetAllCards createGetAllCards() {
        return new GetAllCards();
    }

    /**
     * Create an instance of {@link GetAllCardsResponse }
     * 
     */
    public GetAllCardsResponse createGetAllCardsResponse() {
        return new GetAllCardsResponse();
    }

    /**
     * Create an instance of {@link GetAllCompanys }
     * 
     */
    public GetAllCompanys createGetAllCompanys() {
        return new GetAllCompanys();
    }

    /**
     * Create an instance of {@link GetAllCompanysResponse }
     * 
     */
    public GetAllCompanysResponse createGetAllCompanysResponse() {
        return new GetAllCompanysResponse();
    }

    /**
     * Create an instance of {@link GetAllACCodes }
     * 
     */
    public GetAllACCodes createGetAllACCodes() {
        return new GetAllACCodes();
    }

    /**
     * Create an instance of {@link GetAllACCodesResponse }
     * 
     */
    public GetAllACCodesResponse createGetAllACCodesResponse() {
        return new GetAllACCodesResponse();
    }

    /**
     * Create an instance of {@link GetCompanyACCodes }
     * 
     */
    public GetCompanyACCodes createGetCompanyACCodes() {
        return new GetCompanyACCodes();
    }

    /**
     * Create an instance of {@link GetCompanyACCodesResponse }
     * 
     */
    public GetCompanyACCodesResponse createGetCompanyACCodesResponse() {
        return new GetCompanyACCodesResponse();
    }

    /**
     * Create an instance of {@link GetACCodeAccessDuration }
     * 
     */
    public GetACCodeAccessDuration createGetACCodeAccessDuration() {
        return new GetACCodeAccessDuration();
    }

    /**
     * Create an instance of {@link GetACCodeAccessDurationResponse }
     * 
     */
    public GetACCodeAccessDurationResponse createGetACCodeAccessDurationResponse() {
        return new GetACCodeAccessDurationResponse();
    }

    /**
     * Create an instance of {@link GetAllReaders }
     * 
     */
    public GetAllReaders createGetAllReaders() {
        return new GetAllReaders();
    }

    /**
     * Create an instance of {@link GetAllReadersResponse }
     * 
     */
    public GetAllReadersResponse createGetAllReadersResponse() {
        return new GetAllReadersResponse();
    }

    /**
     * Create an instance of {@link GetAllTimeZones }
     * 
     */
    public GetAllTimeZones createGetAllTimeZones() {
        return new GetAllTimeZones();
    }

    /**
     * Create an instance of {@link GetAllTimeZonesResponse }
     * 
     */
    public GetAllTimeZonesResponse createGetAllTimeZonesResponse() {
        return new GetAllTimeZonesResponse();
    }

    /**
     * Create an instance of {@link QueryPersons }
     * 
     */
    public QueryPersons createQueryPersons() {
        return new QueryPersons();
    }

    /**
     * Create an instance of {@link QueryPersonsResponse }
     * 
     */
    public QueryPersonsResponse createQueryPersonsResponse() {
        return new QueryPersonsResponse();
    }

    /**
     * Create an instance of {@link QueryCards }
     * 
     */
    public QueryCards createQueryCards() {
        return new QueryCards();
    }

    /**
     * Create an instance of {@link QueryCardsResponse }
     * 
     */
    public QueryCardsResponse createQueryCardsResponse() {
        return new QueryCardsResponse();
    }

    /**
     * Create an instance of {@link AddPerson }
     * 
     */
    public AddPerson createAddPerson() {
        return new AddPerson();
    }

    /**
     * Create an instance of {@link AddPersonResponse }
     * 
     */
    public AddPersonResponse createAddPersonResponse() {
        return new AddPersonResponse();
    }

    /**
     * Create an instance of {@link RemovePerson }
     * 
     */
    public RemovePerson createRemovePerson() {
        return new RemovePerson();
    }

    /**
     * Create an instance of {@link RemovePersonResponse }
     * 
     */
    public RemovePersonResponse createRemovePersonResponse() {
        return new RemovePersonResponse();
    }

    /**
     * Create an instance of {@link AddCard }
     * 
     */
    public AddCard createAddCard() {
        return new AddCard();
    }

    /**
     * Create an instance of {@link AddCardResponse }
     * 
     */
    public AddCardResponse createAddCardResponse() {
        return new AddCardResponse();
    }

    /**
     * Create an instance of {@link RemoveCard }
     * 
     */
    public RemoveCard createRemoveCard() {
        return new RemoveCard();
    }

    /**
     * Create an instance of {@link RemoveCardResponse }
     * 
     */
    public RemoveCardResponse createRemoveCardResponse() {
        return new RemoveCardResponse();
    }

    /**
     * Create an instance of {@link AddACCodeToCompany }
     * 
     */
    public AddACCodeToCompany createAddACCodeToCompany() {
        return new AddACCodeToCompany();
    }

    /**
     * Create an instance of {@link AddACCodeToCompanyResponse }
     * 
     */
    public AddACCodeToCompanyResponse createAddACCodeToCompanyResponse() {
        return new AddACCodeToCompanyResponse();
    }

    /**
     * Create an instance of {@link RemoveACCodeFromCompany }
     * 
     */
    public RemoveACCodeFromCompany createRemoveACCodeFromCompany() {
        return new RemoveACCodeFromCompany();
    }

    /**
     * Create an instance of {@link RemoveACCodeFromCompanyResponse }
     * 
     */
    public RemoveACCodeFromCompanyResponse createRemoveACCodeFromCompanyResponse() {
        return new RemoveACCodeFromCompanyResponse();
    }

    /**
     * Create an instance of {@link AddACCodeToCard }
     * 
     */
    public AddACCodeToCard createAddACCodeToCard() {
        return new AddACCodeToCard();
    }

    /**
     * Create an instance of {@link AddACCodeToCardResponse }
     * 
     */
    public AddACCodeToCardResponse createAddACCodeToCardResponse() {
        return new AddACCodeToCardResponse();
    }

    /**
     * Create an instance of {@link RemoveACCodeFromCard }
     * 
     */
    public RemoveACCodeFromCard createRemoveACCodeFromCard() {
        return new RemoveACCodeFromCard();
    }

    /**
     * Create an instance of {@link RemoveACCodeFromCardResponse }
     * 
     */
    public RemoveACCodeFromCardResponse createRemoveACCodeFromCardResponse() {
        return new RemoveACCodeFromCardResponse();
    }

    /**
     * Create an instance of {@link GetACCodeCards }
     * 
     */
    public GetACCodeCards createGetACCodeCards() {
        return new GetACCodeCards();
    }

    /**
     * Create an instance of {@link GetACCodeCardsResponse }
     * 
     */
    public GetACCodeCardsResponse createGetACCodeCardsResponse() {
        return new GetACCodeCardsResponse();
    }

    /**
     * Create an instance of {@link AddReaderToACCode }
     * 
     */
    public AddReaderToACCode createAddReaderToACCode() {
        return new AddReaderToACCode();
    }

    /**
     * Create an instance of {@link AddReaderToACCodeResponse }
     * 
     */
    public AddReaderToACCodeResponse createAddReaderToACCodeResponse() {
        return new AddReaderToACCodeResponse();
    }

    /**
     * Create an instance of {@link RemoveReaderFromACCode }
     * 
     */
    public RemoveReaderFromACCode createRemoveReaderFromACCode() {
        return new RemoveReaderFromACCode();
    }

    /**
     * Create an instance of {@link RemoveReaderFromACCodeResponse }
     * 
     */
    public RemoveReaderFromACCodeResponse createRemoveReaderFromACCodeResponse() {
        return new RemoveReaderFromACCodeResponse();
    }

    /**
     * Create an instance of {@link GetCardReaders }
     * 
     */
    public GetCardReaders createGetCardReaders() {
        return new GetCardReaders();
    }

    /**
     * Create an instance of {@link GetCardReadersResponse }
     * 
     */
    public GetCardReadersResponse createGetCardReadersResponse() {
        return new GetCardReadersResponse();
    }

    /**
     * Create an instance of {@link GetCardReaderTimeZones }
     * 
     */
    public GetCardReaderTimeZones createGetCardReaderTimeZones() {
        return new GetCardReaderTimeZones();
    }

    /**
     * Create an instance of {@link GetCardReaderTimeZonesResponse }
     * 
     */
    public GetCardReaderTimeZonesResponse createGetCardReaderTimeZonesResponse() {
        return new GetCardReaderTimeZonesResponse();
    }

    /**
     * Create an instance of {@link AddReaderToCard }
     * 
     */
    public AddReaderToCard createAddReaderToCard() {
        return new AddReaderToCard();
    }

    /**
     * Create an instance of {@link AddReaderToCardResponse }
     * 
     */
    public AddReaderToCardResponse createAddReaderToCardResponse() {
        return new AddReaderToCardResponse();
    }

    /**
     * Create an instance of {@link RemoveReaderFromCard }
     * 
     */
    public RemoveReaderFromCard createRemoveReaderFromCard() {
        return new RemoveReaderFromCard();
    }

    /**
     * Create an instance of {@link RemoveReaderFromCardResponse }
     * 
     */
    public RemoveReaderFromCardResponse createRemoveReaderFromCardResponse() {
        return new RemoveReaderFromCardResponse();
    }

    /**
     * Create an instance of {@link QueryReaders }
     * 
     */
    public QueryReaders createQueryReaders() {
        return new QueryReaders();
    }

    /**
     * Create an instance of {@link QueryReadersResponse }
     * 
     */
    public QueryReadersResponse createQueryReadersResponse() {
        return new QueryReadersResponse();
    }

    /**
     * Create an instance of {@link ReaderControl }
     * 
     */
    public ReaderControl createReaderControl() {
        return new ReaderControl();
    }

    /**
     * Create an instance of {@link GetReaderStatus }
     * 
     */
    public GetReaderStatus createGetReaderStatus() {
        return new GetReaderStatus();
    }

    /**
     * Create an instance of {@link GetReaderStatusResponse }
     * 
     */
    public GetReaderStatusResponse createGetReaderStatusResponse() {
        return new GetReaderStatusResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strDBAddr", scope = Init.class)
    public JAXBElement<String> createInitInStrDBAddr(String value) {
        return new JAXBElement<String>(_InitInStrDBAddr_QNAME, String.class, Init.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strDBName", scope = Init.class)
    public JAXBElement<String> createInitInStrDBName(String value) {
        return new JAXBElement<String>(_InitInStrDBName_QNAME, String.class, Init.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strDBUser", scope = Init.class)
    public JAXBElement<String> createInitInStrDBUser(String value) {
        return new JAXBElement<String>(_InitInStrDBUser_QNAME, String.class, Init.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strDBPassword", scope = Init.class)
    public JAXBElement<String> createInitInStrDBPassword(String value) {
        return new JAXBElement<String>(_InitInStrDBPassword_QNAME, String.class, Init.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strPCAddr", scope = Init.class)
    public JAXBElement<String> createInitInStrPCAddr(String value) {
        return new JAXBElement<String>(_InitInStrPCAddr_QNAME, String.class, Init.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strPCUser", scope = Init.class)
    public JAXBElement<String> createInitInStrPCUser(String value) {
        return new JAXBElement<String>(_InitInStrPCUser_QNAME, String.class, Init.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strPCPassword", scope = InitResponse.class)
    public JAXBElement<String> createInitResponseInStrPCPassword(String value) {
        return new JAXBElement<String>(_InitResponseInStrPCPassword_QNAME, String.class, InitResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structPersons", scope = GetAllPersonsResponse.class)
    public JAXBElement<String> createGetAllPersonsResponseOutStructPersons(String value) {
        return new JAXBElement<String>(_GetAllPersonsResponseOutStructPersons_QNAME, String.class, GetAllPersonsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-sPersonID", scope = GetAllBadgeTypes.class)
    public JAXBElement<String> createGetAllBadgeTypesInSPersonID(String value) {
        return new JAXBElement<String>(_GetAllBadgeTypesInSPersonID_QNAME, String.class, GetAllBadgeTypes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structBadgeTypes", scope = GetAllBadgeTypesResponse.class)
    public JAXBElement<String> createGetAllBadgeTypesResponseOutStructBadgeTypes(String value) {
        return new JAXBElement<String>(_GetAllBadgeTypesResponseOutStructBadgeTypes_QNAME, String.class, GetAllBadgeTypesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-sPersonID", scope = GetAllCards.class)
    public JAXBElement<String> createGetAllCardsInSPersonID(String value) {
        return new JAXBElement<String>(_GetAllBadgeTypesInSPersonID_QNAME, String.class, GetAllCards.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structCards", scope = GetAllCardsResponse.class)
    public JAXBElement<String> createGetAllCardsResponseOutStructCards(String value) {
        return new JAXBElement<String>(_GetAllCardsResponseOutStructCards_QNAME, String.class, GetAllCardsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCARDNO", scope = GetAllCompanys.class)
    public JAXBElement<String> createGetAllCompanysInStrCARDNO(String value) {
        return new JAXBElement<String>(_GetAllCompanysInStrCARDNO_QNAME, String.class, GetAllCompanys.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structCompanys", scope = GetAllCompanysResponse.class)
    public JAXBElement<String> createGetAllCompanysResponseOutStructCompanys(String value) {
        return new JAXBElement<String>(_GetAllCompanysResponseOutStructCompanys_QNAME, String.class, GetAllCompanysResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strPersonID", scope = GetAllACCodes.class)
    public JAXBElement<String> createGetAllACCodesInStrPersonID(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrPersonID_QNAME, String.class, GetAllACCodes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCardNO", scope = GetAllACCodes.class)
    public JAXBElement<String> createGetAllACCodesInStrCardNO(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrCardNO_QNAME, String.class, GetAllACCodes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structACCodes", scope = GetAllACCodesResponse.class)
    public JAXBElement<String> createGetAllACCodesResponseOutStructACCodes(String value) {
        return new JAXBElement<String>(_GetAllACCodesResponseOutStructACCodes_QNAME, String.class, GetAllACCodesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCompanyID", scope = GetCompanyACCodes.class)
    public JAXBElement<String> createGetCompanyACCodesInStrCompanyID(String value) {
        return new JAXBElement<String>(_GetCompanyACCodesInStrCompanyID_QNAME, String.class, GetCompanyACCodes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structACCodes", scope = GetCompanyACCodesResponse.class)
    public JAXBElement<String> createGetCompanyACCodesResponseOutStructACCodes(String value) {
        return new JAXBElement<String>(_GetAllACCodesResponseOutStructACCodes_QNAME, String.class, GetCompanyACCodesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = GetACCodeAccessDuration.class)
    public JAXBElement<String> createGetACCodeAccessDurationInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, GetACCodeAccessDuration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structAccessDuration", scope = GetACCodeAccessDurationResponse.class)
    public JAXBElement<String> createGetACCodeAccessDurationResponseOutStructAccessDuration(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationResponseOutStructAccessDuration_QNAME, String.class, GetACCodeAccessDurationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = GetAllReaders.class)
    public JAXBElement<String> createGetAllReadersInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, GetAllReaders.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structReaders", scope = GetAllReadersResponse.class)
    public JAXBElement<String> createGetAllReadersResponseOutStructReaders(String value) {
        return new JAXBElement<String>(_GetAllReadersResponseOutStructReaders_QNAME, String.class, GetAllReadersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = GetAllTimeZones.class)
    public JAXBElement<String> createGetAllTimeZonesInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, GetAllTimeZones.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strReaderID", scope = GetAllTimeZones.class)
    public JAXBElement<String> createGetAllTimeZonesInStrReaderID(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesInStrReaderID_QNAME, String.class, GetAllTimeZones.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structTimeZone", scope = GetAllTimeZonesResponse.class)
    public JAXBElement<String> createGetAllTimeZonesResponseOutStructTimeZone(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesResponseOutStructTimeZone_QNAME, String.class, GetAllTimeZonesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strField", scope = QueryPersons.class)
    public JAXBElement<String> createQueryPersonsInStrField(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrField_QNAME, String.class, QueryPersons.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strOper", scope = QueryPersons.class)
    public JAXBElement<String> createQueryPersonsInStrOper(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrOper_QNAME, String.class, QueryPersons.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strValue", scope = QueryPersons.class)
    public JAXBElement<String> createQueryPersonsInStrValue(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrValue_QNAME, String.class, QueryPersons.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structPersons", scope = QueryPersonsResponse.class)
    public JAXBElement<String> createQueryPersonsResponseOutStructPersons(String value) {
        return new JAXBElement<String>(_GetAllPersonsResponseOutStructPersons_QNAME, String.class, QueryPersonsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strField", scope = QueryCards.class)
    public JAXBElement<String> createQueryCardsInStrField(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrField_QNAME, String.class, QueryCards.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strOper", scope = QueryCards.class)
    public JAXBElement<String> createQueryCardsInStrOper(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrOper_QNAME, String.class, QueryCards.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strValue", scope = QueryCards.class)
    public JAXBElement<String> createQueryCardsInStrValue(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrValue_QNAME, String.class, QueryCards.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structCards", scope = QueryCardsResponse.class)
    public JAXBElement<String> createQueryCardsResponseOutStructCards(String value) {
        return new JAXBElement<String>(_GetAllCardsResponseOutStructCards_QNAME, String.class, QueryCardsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-structPerson", scope = AddPerson.class)
    public JAXBElement<String> createAddPersonInStructPerson(String value) {
        return new JAXBElement<String>(_AddPersonInStructPerson_QNAME, String.class, AddPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strBadgeTypeID", scope = AddPerson.class)
    public JAXBElement<String> createAddPersonInStrBadgeTypeID(String value) {
        return new JAXBElement<String>(_AddPersonInStrBadgeTypeID_QNAME, String.class, AddPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sPersonID", scope = AddPersonResponse.class)
    public JAXBElement<String> createAddPersonResponseSPersonID(String value) {
        return new JAXBElement<String>(_AddPersonResponseSPersonID_QNAME, String.class, AddPersonResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strPersonID", scope = RemovePersonResponse.class)
    public JAXBElement<String> createRemovePersonResponseInStrPersonID(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrPersonID_QNAME, String.class, RemovePersonResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-structCard", scope = AddCard.class)
    public JAXBElement<String> createAddCardInStructCard(String value) {
        return new JAXBElement<String>(_AddCardInStructCard_QNAME, String.class, AddCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCompanyID", scope = AddCardResponse.class)
    public JAXBElement<String> createAddCardResponseInStrCompanyID(String value) {
        return new JAXBElement<String>(_GetCompanyACCodesInStrCompanyID_QNAME, String.class, AddCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCARDNO", scope = RemoveCardResponse.class)
    public JAXBElement<String> createRemoveCardResponseInStrCARDNO(String value) {
        return new JAXBElement<String>(_GetAllCompanysInStrCARDNO_QNAME, String.class, RemoveCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = AddACCodeToCompany.class)
    public JAXBElement<String> createAddACCodeToCompanyInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, AddACCodeToCompany.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCompanyID", scope = AddACCodeToCompanyResponse.class)
    public JAXBElement<String> createAddACCodeToCompanyResponseInStrCompanyID(String value) {
        return new JAXBElement<String>(_GetCompanyACCodesInStrCompanyID_QNAME, String.class, AddACCodeToCompanyResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = RemoveACCodeFromCompany.class)
    public JAXBElement<String> createRemoveACCodeFromCompanyInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, RemoveACCodeFromCompany.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCompanyID", scope = RemoveACCodeFromCompanyResponse.class)
    public JAXBElement<String> createRemoveACCodeFromCompanyResponseInStrCompanyID(String value) {
        return new JAXBElement<String>(_GetCompanyACCodesInStrCompanyID_QNAME, String.class, RemoveACCodeFromCompanyResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = AddACCodeToCard.class)
    public JAXBElement<String> createAddACCodeToCardInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, AddACCodeToCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCardNO", scope = AddACCodeToCardResponse.class)
    public JAXBElement<String> createAddACCodeToCardResponseInStrCardNO(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrCardNO_QNAME, String.class, AddACCodeToCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = RemoveACCodeFromCard.class)
    public JAXBElement<String> createRemoveACCodeFromCardInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, RemoveACCodeFromCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCardNO", scope = RemoveACCodeFromCardResponse.class)
    public JAXBElement<String> createRemoveACCodeFromCardResponseInStrCardNO(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrCardNO_QNAME, String.class, RemoveACCodeFromCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = GetACCodeCards.class)
    public JAXBElement<String> createGetACCodeCardsInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, GetACCodeCards.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structCards", scope = GetACCodeCardsResponse.class)
    public JAXBElement<String> createGetACCodeCardsResponseOutStructCards(String value) {
        return new JAXBElement<String>(_GetAllCardsResponseOutStructCards_QNAME, String.class, GetACCodeCardsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = AddReaderToACCode.class)
    public JAXBElement<String> createAddReaderToACCodeInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, AddReaderToACCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strReaderID", scope = AddReaderToACCode.class)
    public JAXBElement<String> createAddReaderToACCodeInStrReaderID(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesInStrReaderID_QNAME, String.class, AddReaderToACCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strTimeZoneID", scope = AddReaderToACCodeResponse.class)
    public JAXBElement<String> createAddReaderToACCodeResponseInStrTimeZoneID(String value) {
        return new JAXBElement<String>(_AddReaderToACCodeResponseInStrTimeZoneID_QNAME, String.class, AddReaderToACCodeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strACCodeID", scope = RemoveReaderFromACCode.class)
    public JAXBElement<String> createRemoveReaderFromACCodeInStrACCodeID(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationInStrACCodeID_QNAME, String.class, RemoveReaderFromACCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strReaderID", scope = RemoveReaderFromACCode.class)
    public JAXBElement<String> createRemoveReaderFromACCodeInStrReaderID(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesInStrReaderID_QNAME, String.class, RemoveReaderFromACCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strTimeZoneID", scope = RemoveReaderFromACCodeResponse.class)
    public JAXBElement<String> createRemoveReaderFromACCodeResponseInStrTimeZoneID(String value) {
        return new JAXBElement<String>(_AddReaderToACCodeResponseInStrTimeZoneID_QNAME, String.class, RemoveReaderFromACCodeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCardNO", scope = GetCardReaders.class)
    public JAXBElement<String> createGetCardReadersInStrCardNO(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrCardNO_QNAME, String.class, GetCardReaders.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structReaders", scope = GetCardReadersResponse.class)
    public JAXBElement<String> createGetCardReadersResponseOutStructReaders(String value) {
        return new JAXBElement<String>(_GetAllReadersResponseOutStructReaders_QNAME, String.class, GetCardReadersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCardNO", scope = GetCardReaderTimeZones.class)
    public JAXBElement<String> createGetCardReaderTimeZonesInStrCardNO(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrCardNO_QNAME, String.class, GetCardReaderTimeZones.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strReaderID", scope = GetCardReaderTimeZones.class)
    public JAXBElement<String> createGetCardReaderTimeZonesInStrReaderID(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesInStrReaderID_QNAME, String.class, GetCardReaderTimeZones.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structTimeZone", scope = GetCardReaderTimeZones.class)
    public JAXBElement<String> createGetCardReaderTimeZonesOutStructTimeZone(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesResponseOutStructTimeZone_QNAME, String.class, GetCardReaderTimeZones.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structAccessDuration", scope = GetCardReaderTimeZonesResponse.class)
    public JAXBElement<String> createGetCardReaderTimeZonesResponseOutStructAccessDuration(String value) {
        return new JAXBElement<String>(_GetACCodeAccessDurationResponseOutStructAccessDuration_QNAME, String.class, GetCardReaderTimeZonesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCardNO", scope = AddReaderToCard.class)
    public JAXBElement<String> createAddReaderToCardInStrCardNO(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrCardNO_QNAME, String.class, AddReaderToCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strReaderID", scope = AddReaderToCard.class)
    public JAXBElement<String> createAddReaderToCardInStrReaderID(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesInStrReaderID_QNAME, String.class, AddReaderToCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strTimeZoneID", scope = AddReaderToCard.class)
    public JAXBElement<String> createAddReaderToCardInStrTimeZoneID(String value) {
        return new JAXBElement<String>(_AddReaderToACCodeResponseInStrTimeZoneID_QNAME, String.class, AddReaderToCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strTEMPACCESS", scope = AddReaderToCard.class)
    public JAXBElement<String> createAddReaderToCardInStrTEMPACCESS(String value) {
        return new JAXBElement<String>(_AddReaderToCardInStrTEMPACCESS_QNAME, String.class, AddReaderToCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strTEMPACCESS-START-TIME", scope = AddReaderToCard.class)
    public JAXBElement<String> createAddReaderToCardInStrTEMPACCESSSTARTTIME(String value) {
        return new JAXBElement<String>(_AddReaderToCardInStrTEMPACCESSSTARTTIME_QNAME, String.class, AddReaderToCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strTEMPACCESS-END-TIME", scope = AddReaderToCardResponse.class)
    public JAXBElement<String> createAddReaderToCardResponseInStrTEMPACCESSENDTIME(String value) {
        return new JAXBElement<String>(_AddReaderToCardResponseInStrTEMPACCESSENDTIME_QNAME, String.class, AddReaderToCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strCardNO", scope = RemoveReaderFromCard.class)
    public JAXBElement<String> createRemoveReaderFromCardInStrCardNO(String value) {
        return new JAXBElement<String>(_GetAllACCodesInStrCardNO_QNAME, String.class, RemoveReaderFromCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strReaderID", scope = RemoveReaderFromCardResponse.class)
    public JAXBElement<String> createRemoveReaderFromCardResponseInStrReaderID(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesInStrReaderID_QNAME, String.class, RemoveReaderFromCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strField", scope = QueryReaders.class)
    public JAXBElement<String> createQueryReadersInStrField(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrField_QNAME, String.class, QueryReaders.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strOper", scope = QueryReaders.class)
    public JAXBElement<String> createQueryReadersInStrOper(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrOper_QNAME, String.class, QueryReaders.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strValue", scope = QueryReaders.class)
    public JAXBElement<String> createQueryReadersInStrValue(String value) {
        return new JAXBElement<String>(_QueryPersonsInStrValue_QNAME, String.class, QueryReaders.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "out-structReaders", scope = QueryReadersResponse.class)
    public JAXBElement<String> createQueryReadersResponseOutStructReaders(String value) {
        return new JAXBElement<String>(_GetAllReadersResponseOutStructReaders_QNAME, String.class, QueryReadersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strReaderID", scope = ReaderControl.class)
    public JAXBElement<String> createReaderControlInStrReaderID(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesInStrReaderID_QNAME, String.class, ReaderControl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strReaderID", scope = GetReaderStatus.class)
    public JAXBElement<String> createGetReaderStatusInStrReaderID(String value) {
        return new JAXBElement<String>(_GetAllTimeZonesInStrReaderID_QNAME, String.class, GetReaderStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "in-strStatus", scope = GetReaderStatusResponse.class)
    public JAXBElement<String> createGetReaderStatusResponseInStrStatus(String value) {
        return new JAXBElement<String>(_GetReaderStatusResponseInStrStatus_QNAME, String.class, GetReaderStatusResponse.class, value);
    }

}
