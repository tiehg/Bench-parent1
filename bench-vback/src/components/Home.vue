<template>
  <div>
    <el-container>
      <!--头部导航区-->
      <el-header>
        <router-view name="top"></router-view>
      </el-header>
      <el-container>
        <!--左侧导航区-->
        <el-aside width="200px">
          <router-view name="left"></router-view>
        </el-aside>
        <!--右侧内容区-->
        <el-main>Main
          <router-view></router-view>
        </el-main>

      </el-container>
    </el-container>

  </div>
</template>

<script>
import TopNavMenu from "./common/TopNavMenu";

export default {
  name: "Home",
}
</script>

<style scoped>

</style>
