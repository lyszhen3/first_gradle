import java.util.List;

/**
 * Created by lys on 2018/9/20.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
public class Fxcs<T> {

	private List<?> contents;

	public List<?> getContents() {
		return contents;
	}

	public void setContents(List<?> contents) {
		this.contents = contents;
	}

	public static void main(String[] args) {
		Class<Fxcs> fxcsClass = Fxcs.class;

	}
}
