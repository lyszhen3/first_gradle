import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lys on 2018/9/26.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
public class SubClass extends SuperClass{
	private String id;



	public SubClass(String id){
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public static void main(String[] args) {
		List<String> list =new ArrayList<>();
		list.remove(1);
	}
}
