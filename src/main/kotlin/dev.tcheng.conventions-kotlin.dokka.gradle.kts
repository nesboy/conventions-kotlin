import org.jetbrains.dokka.gradle.DokkaExtension
import org.jetbrains.dokka.gradle.engine.parameters.VisibilityModifier

plugins {
    id("org.jetbrains.dokka")
}

extensions.configure<DokkaExtension> {
    dokkaSourceSets.configureEach {
        dokkaPublications.html {
            suppressInheritedMembers.set(true)
            failOnWarning.set(true)
        }

        documentedVisibilities.set(
            setOf(VisibilityModifier.Public, VisibilityModifier.Protected)
        )
    }
}
