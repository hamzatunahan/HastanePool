package HastaneYatakSistemi;

import java.util.ArrayList;
import java.util.List;

public class Pool {
    private static volatile Pool pickerPool = null;
    private int PickerCount = 10;
    private List<HastaneYatak> _available = new ArrayList<HastaneYatak>();
    private List<HastaneYatak> _inUse = new ArrayList<HastaneYatak>();

    private Pool() {
        createPickerPool(PickerCount);
    }

    public static Pool getInstance() {

        if (pickerPool == null) {

            synchronized (Pool.class) {

                if (pickerPool == null) {

                    pickerPool = new Pool();
                }
            }
        }
        return pickerPool;
    }

    private void createPickerPool(int PickerCount) {    // Poolumuza object ekliyor
        for (int i = 1; i <= PickerCount; i++) {
            _available.add(new HastaneYatak(i));

        }
    }

    public HastaneYatak YatakBul() {
        synchronized (_available) {
            if ((_available.size()) != 0) {
                HastaneYatak picker = _available.get(0);

                _inUse.add(picker);
                _available.remove(0);

                return picker;
            } else {
                return null;
            }
        }

    }

    public void YatakBırak(HastaneYatak picker) {

        synchronized (_available) {
            _available.add(picker);
            _inUse.remove(picker);

        }
    }


    @Override
    public String toString() {
        return "PickerPool{" +
                "PickerCount=" + PickerCount +
                ", _available=" + _available.size() +
                ", _inUse=" + _inUse.size() +
                '}';
    }
}
