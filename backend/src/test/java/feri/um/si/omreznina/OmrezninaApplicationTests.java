package feri.um.si.omreznina;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.google.firebase.internal.FirebaseService;

@SpringBootTest
@ActiveProfiles("test")
class OmrezninaApplicationTests {


    @Mock
    private FirebaseService<Object> firebaseService;

	@Test
	void contextLoads() {
	}

}
