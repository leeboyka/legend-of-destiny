<template>
  <div id="blogHome">
    <el-row :gutter="20">
      <el-col :span="6">
        <el-row>
          <el-col :span="8" :offset="16">
            <nav-tab-bar style="margin-bottom: 20px"></nav-tab-bar>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="10">
        <main-view></main-view>
      </el-col>
      <el-col :span="8">
        <el-row>
          <el-col :span="12">
            <personal-tab style="margin-bottom: 20px"></personal-tab>
            <concern-tab style="margin-bottom: 20px"></concern-tab>
            <announcement></announcement>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import mainView from './center/MainView'
import navTabBar from './left/NavTabBar'
import concernTab from '../home/Layout/ConcernTab'
import personalTab from './right/PersonalTab'
import announcement from './right/Announcement'

export default {
  name: 'BlogHome',
  components: {
    mainView,
    navTabBar,
    concernTab,
    personalTab,
    announcement
  }
}
</script>

<style lang="scss">
  #blogHome {
    text-align: left;
  }

</style>
