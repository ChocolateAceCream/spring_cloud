package di.dell.stream.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeRegistrationSource {
    // defined the output channel named employeeRegistrationChannel
    // @Output annotation is used to indicate the name of output channel
    @Output("employeeRegistrationChannel")
    MessageChannel employeeRegistration();
}
