import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class UriCompTest  {

	@Test
	public void testUriComps() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("one", "test1");
		map.put("two", "test2");

		System.out.println(UriComponentsBuilder.fromPath("/test/{one}/{two}").buildAndExpand(map).toUriString());
	}
}
