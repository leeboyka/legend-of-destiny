<template>
    <div>
      <template v-for="(child,index) in menuData">
        <el-submenu :key="index" v-if="child.children.length > 0" :index="child.path">
          <template slot="title">
            <font-awesome-icon :icon="child.iconNameAwesome"/>
            <span slot="title" class="menu-title">{{ $t(`routeName.${child.name}`) }}</span>
          </template>
          <menu-tree :menuData="child.children"></menu-tree>
        </el-submenu>

        <el-menu-item :key="index" v-else-if="!child.hidden" :index="child.path">
          <font-awesome-icon :icon="child.iconNameAwesome"/>
          <span slot="title" class="menu-title">{{ $t(`routeName.${child.name}`) }}</span>
        </el-menu-item>
      </template>
    </div>
</template>

<script>
export default {
  name: 'menuTree',
  props: ['menuData']
}
</script>

<style scoped>

</style>
