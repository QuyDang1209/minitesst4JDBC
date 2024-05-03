package model;

import java.util.List;

public interface IGlasessDAO {
    public void insertGlasses(Glasses glass);
    public Glasses findGlass(int id);
    public List<Glasses> selectAllGlasess();
    public boolean deleteGlasses(int id) throws Exception;
    public boolean updateGlasses(Glasses glass) throws Exception;
}
