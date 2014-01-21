
public class RenderSystem extends System {
	
	public RenderSystem(EntityManager entityManager) {
		super(entityManager);
		actionableComponents.add(Position.class);
		actionableComponents.add(Sprite.class);
	}
	
	public void update() {
		for (Entity e : actionableEntities) {
			//Render entity here using drawing library
		}
	}
}
