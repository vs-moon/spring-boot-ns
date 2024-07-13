import org.xiao.ns.domain.po.Menu;
import org.xiao.ns.domain.vo.MenuVO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {


    public static void main(String[] args) {
        List<Menu> arrayList = new ArrayList<>();
        arrayList.add(new Menu());
        List<MenuVO> convert = convert(arrayList, a -> hasChildren(a, MenuVO::new, b -> {
            b.setHasChildren(true);
        }));
    }

    public static  <R extends T, T> List<R> convert(List<T> args, Function<T, R> function) {
        List<R> list = new ArrayList<R>(args.size());
        for (T t : args) {
            list.add(function.apply(t));
        }
        return list;
    }

    public static  <R extends T, T> R hasChildren(T args, Function<T, R> function, Consumer<R> consumer) {
        R apply = function.apply(args);
        consumer.accept(apply);
        return apply;
    }
}
