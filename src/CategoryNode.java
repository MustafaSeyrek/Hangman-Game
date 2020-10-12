

public class CategoryNode {
    private int CategoryName;//length of words
    private CategoryNode down;
    private ItemNode right;

    public CategoryNode(int dataToAdd) {
        CategoryName = dataToAdd;
        down = null;
        right = null;
    }

    public Object getCategoryName() { return CategoryName; }
    public void setCategoryName(int data) { this.CategoryName = data;  }
    public CategoryNode getDown() { return down;  }
    public void setDown(CategoryNode down) { this.down = down;   }
    public ItemNode getRight() { return right;  }
    public void setRight(ItemNode right) { this.right = right;   }
}