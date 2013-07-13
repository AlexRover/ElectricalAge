package mods.eln.electricasensor;

import java.util.List;

import mods.eln.Eln;
import mods.eln.cable.CableRenderDescriptor;
import mods.eln.client.ClientProxy;
import mods.eln.misc.IFunction;
import mods.eln.misc.Obj3D;
import mods.eln.misc.Obj3D.Obj3DPart;
import mods.eln.node.SixNodeDescriptor;
import mods.eln.sim.DiodeProcess;
import mods.eln.sim.ElectricalLoad;
import mods.eln.sim.ElectricalResistor;
import mods.eln.sim.ThermalLoadInitializer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

import com.google.common.base.Function;


public class ElectricalSensorDescriptor extends SixNodeDescriptor{

	public ElectricalSensorDescriptor(		
					String name,String modelName,
					boolean voltageOnly
					) {
			super(name, ElectricalSensorElement.class, ElectricalSensorRender.class);
			this.voltageOnly = voltageOnly;
			main = Eln.obj.getPart(modelName, "main");
		}
	boolean voltageOnly;
	Obj3DPart main;
	
	
	void draw()
	{
		if(main != null) main.drawList();
	}
	
	
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		draw();
	}
	
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer,
			List list, boolean par4) {
		// TODO Auto-generated method stub
		super.addInformation(itemStack, entityPlayer, list, par4);
		
		if(voltageOnly){
			list.add("In function of input voltage,");
			list.add("give a output voltage signal");
		}
		else
		{
			list.add("In function of inputs,");
			list.add("give a output voltage signal");
			list.add("Can measure :");
			list.add("Voltage/Power/Current");
		}
	}
}
