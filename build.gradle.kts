plugins {
    id("org.openrewrite.build.recipe-library") version "latest.release"
}

group = "org.openrewrite.recipe"
description = "Recipes to migrate to the IBM WebSphere Liberty. Automatically."

val rewriteVersion = rewriteRecipe.rewriteVersion.get()
dependencies {
    implementation(platform("org.openrewrite:rewrite-bom:$rewriteVersion"))
    implementation(platform("org.openrewrite.recipe:rewrite-recipe-bom:$rewriteVersion"))
    implementation("org.openrewrite:rewrite-java")
    implementation("org.openrewrite.recipe:rewrite-java-dependencies")
    implementation("org.openrewrite.recipe:rewrite-migrate-java")
    implementation("org.openrewrite.recipe:rewrite-static-analysis")

    testImplementation("org.openrewrite:rewrite-java-17")
    testImplementation("org.openrewrite:rewrite-test")
    testImplementation("org.openrewrite:rewrite-gradle")
    testImplementation("org.openrewrite:rewrite-maven")

    // TODO replace with the last release that contained `WSSecurityHelper.revokeSSOCookies(req,res)`
    testImplementation("com.ibm.websphere.appserver.api:com.ibm.websphere.appserver.api.basics:latest.release")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:latest.release")
}
