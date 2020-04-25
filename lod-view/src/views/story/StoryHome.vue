<template>
  <div id="storyHome">
    <el-row :gutter="20">
      <el-col :span="7">
        <el-row>
          <el-col :span="14" :offset="10">
            <type-menu style="margin-bottom: 20px"></type-menu>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="10">
        <main-content></main-content>
      </el-col>
      <el-col :span="7">
        <el-row>
          <el-col :span="14">
            <ranking-list style="margin-bottom: 20px"></ranking-list>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import typeMenu from './east/TypeMenu'
import mainContent from './main/MainContent'
import rankingList from './west/RankingList'

export default {
  name: 'StoryHome',
  components: {
    typeMenu,
    mainContent,
    rankingList
  }
}
</script>

<style scoped>

</style>
