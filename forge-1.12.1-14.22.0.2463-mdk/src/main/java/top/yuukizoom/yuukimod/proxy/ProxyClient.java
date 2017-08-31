package top.yuukizoom.yuukimod.proxy;

import top.yuukizoom.yuukimod.YuukiMod;
import top.yuukizoom.yuukimod.entity.EntityRenderLoader;

/**
 * Created by realdata on 2017/8/29.
 */
public class ProxyClient extends ProxyCommon{

    @Override
    public void loadModel() {
        super.loadModel();
        YuukiMod.myItem.loadModel();
        YuukiMod.myBlock.loadModel();
        YuukiMod.myTool.loadModel();
        YuukiMod.myFood.loadModel();
        YuukiMod.blockFluidMercury.loadModel();
        YuukiMod.itemBucketMercury.loadModel();

        new EntityRenderLoader();

    }
}
