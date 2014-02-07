import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntityManager {
	
	private HashMap<Integer, ArrayList<Component>> entityList;
	private int lowestEID = 0;
	
	public int getLowestEID() {
		return lowestEID;
	}
	
	private int generateNewEID() {
		if (lowestEID < Integer.MAX_VALUE) {
			return lowestEID++;
		}
		for(int i=0; i < Integer.MAX_VALUE; i++) {
			if (!entityList.containsKey(i)) {
				return i;
			}
		}
		throw new RuntimeException("Cannot create new EID");
	}
	
	public void addComponent(Entity entity, Component component) {
		entityList.get(entity.getEID()).add(component);
	}
	
	public void addComponent(Entity entity, ArrayList<Component> componentList) {
		ArrayList<Component> tempList = entityList.get(entity.getEID());
		for(Component givenComponent: componentList) {
			for(Component existingComponent: tempList) {
				if (givenComponent.getClass() != existingComponent.getClass()) {
					tempList.add(givenComponent);
				}
			}
		}
	}
	
	public Entity createEntity(ArrayList<Component> componentList) {
		Entity entity = createEntity();
		entityList.put(entity.getEID(), componentList);
		return entity;
	}
	
	public Entity createEntity() {
		Integer eID = generateNewEID();
		Entity entity = new Entity(eID);
		return entity;
	}

	public ArrayList<Component> getEntity(int eID) {
		return entityList.get(eID);
	}
	
	public ArrayList<Entity> getEntityList() {
		ArrayList<Entity> tempEntityList = new ArrayList<Entity>();
		for(Integer i : entityList.keySet()) {
			tempEntityList.add(new Entity(i));
		}
		return tempEntityList;
	}
	
	public <T> boolean containsComponent(Entity entity, Class<T> c) {
		List<Component> componentList = entityList.get(entity.getEID());
		for(Object o : componentList) {
			if (o != null && o.getClass() == c) {
				return true;
			}
		}
		return false;
	}
	
}
