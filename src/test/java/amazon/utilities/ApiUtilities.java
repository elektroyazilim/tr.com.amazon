package amazon.utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtilities {

    public static Response response = null; // durum, cookie, hız, json cevap...

    // connection settings :
    public static RequestSpecification specification = new RequestSpecBuilder()
            .setContentType(ContentType.URLENC.withCharset("UTF-8")).
            addCookie(new Cookie.Builder("PHPSESSID", ConfigurationReader.getPropertyFromProperties("PHPSESSID")).build()).
            setBaseUri("https://test.hypnotes.net/api").
            setRelaxedHTTPSValidation().
            build();


    //////// Hazır Methodlar

}
