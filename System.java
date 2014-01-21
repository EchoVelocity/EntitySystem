import java.util.ArrayList;


public abstract class System {
	private ArrayList<Entity> previousEntityList;
	protected EntityManager entityManager;
	protected ArrayList<Entity> actionableEntities;
	protected ArrayList<Class<?>> actionableComponents;
	
	public System(EntityManager entityManager) {
		this.entityManager = entityManager;
		ArrayList<Class<?>> actionableComponents = new ArrayList<Class<?>>();
		ArrayList<Entity> actionableEntities = new ArrayList<Entity>();
	}
	
	public void gatherActionableEntities() {
		if (previousEntityList == null) {
			ArrayList<Entity> allEntities = entityManager.getEntityList();
		}
		else {
			
		}
		for (Entity entity : allEntities) {
			int componentsMatched = 0;
			for (Class<?> c : actionableComponents) {
				if (entityManager.containsComponent(entity, c)) {
					componentsMatched++;
				}
			}
			if (componentsMatched == actionableComponents.size()) {
				actionableEntities.add(entity);
			}
		}
		
	}
	
	public abstract void update();
	
}
