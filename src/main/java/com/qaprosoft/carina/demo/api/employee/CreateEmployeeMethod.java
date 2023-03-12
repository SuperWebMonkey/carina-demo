package com.qaprosoft.carina.demo.api.employee;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}api/v1/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/employee/_post/rq.json")
@ResponseTemplatePath(path = "api/employee/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class CreateEmployeeMethod extends AbstractApiMethodV2 {

    public CreateEmployeeMethod() {
        super("api/employee/_post/rq.json", "api/employee/_post/rs.json", "api/employee/employee.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
