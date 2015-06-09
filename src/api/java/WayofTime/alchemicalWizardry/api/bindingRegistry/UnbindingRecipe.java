package WayofTime.alchemicalWizardry.api.bindingRegistry;

import net.minecraft.item.ItemStack;

public class UnbindingRecipe
{
    public ItemStack requiredItem;
    public ItemStack outputItem;

    public UnbindingRecipe(ItemStack outputItem, ItemStack requiredItem)
    {
        this.requiredItem = requiredItem;
        this.outputItem = outputItem;
    }

    public boolean doesRequiredItemMatch(ItemStack testStack)
    {
        if (testStack == null || this.requiredItem == null)
        {
            return false;
        }

        return this.requiredItem.isItemEqual(testStack);
    }

    public ItemStack getResult(ItemStack inputItem)
    {
        return this.getResult();
    }

    public ItemStack getResult()
    {
        return this.outputItem;
    }
}
