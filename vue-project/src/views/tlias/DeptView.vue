<template>
<div>
    <el-container style="height: 700px; border: 1px solid #eee">
        <el-header style="font-size: 40px;background-color: rgb(238, 241, 246)">系统名称</el-header>
        <el-container>
            <el-aside width="230px" style="border: 1px solid #eee">
                <el-menu :default-openeds="['1', '3']">
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-message"></i>系统信息管理</template>
                        <el-menu-item index="1-1">
                            <router-link to="/dept">部门管理</router-link>
                        </el-menu-item>
                        <el-menu-item index="1-2">
                            <router-link to="/emp">员工管理</router-link>
                        </el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <el-table
                    :data="tableData"
                    border
                    style="width: 100%">
                    <el-table-column
                        prop="name"
                        label="名称"
                        width="180">
                    </el-table-column>
                    <el-table-column
                        prop="time"
                        label="最后操作时间"
                        width="180">
                    </el-table-column>
                    <el-table-column label="操作" >
                        <el-button type="primary" size="mini">编辑</el-button>
                        <el-button type="danger" size="mini">删除</el-button>
                    </el-table-column>
                </el-table>
            </el-main>
        </el-container>
    </el-container>
</div>
</template>

<script>
export default {
    name: "deptView",
    data(){
        return {
            tableData: [],
        }
    },
}
</script>

<style scoped>

</style>